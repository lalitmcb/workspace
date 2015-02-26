package com.lalit.kafkaStormIntegration.storm;

import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.StringScheme;
import storm.kafka.ZkHosts;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.spout.SchemeAsMultiScheme;
import backtype.storm.topology.TopologyBuilder;

public class KafkaStormIntegration implements Runnable {
	
	LocalCluster stormCluster = null;

	@Override
	public void run() {
        ZkHosts zooKeeperHosts = new ZkHosts("localhost:2181");
        
        String topicName="test";
        String consumerGroup="StormBolt";
        String zookeeperRoot="";
        SpoutConfig kafkaConfig=new SpoutConfig(zooKeeperHosts, topicName, zookeeperRoot, consumerGroup);
        
        kafkaConfig.scheme=new SchemeAsMultiScheme(new StringScheme());
        kafkaConfig.forceFromStart=true;
         
        System.out.println("Building Topology");
        TopologyBuilder builder=new TopologyBuilder();
        builder.setSpout("KafkaSpout", new KafkaSpout(kafkaConfig),new Integer(1));
        builder.setBolt("PrinterBolt", new PrintTextBolt()).globalGrouping("KafkaSpout");
         
        Config config=new Config();
         
        System.out.println("Building Storm Cluster");
        stormCluster =new LocalCluster();
         
        System.out.println("Submit topology");
        stormCluster .submitTopology("KafkaStormIntegrationTopology", config, builder.createTopology());             
	}

	public void stop() {
        stormCluster .killTopology("KafkaStormIntegrationTopology");
	    stormCluster .shutdown();
    }
}
