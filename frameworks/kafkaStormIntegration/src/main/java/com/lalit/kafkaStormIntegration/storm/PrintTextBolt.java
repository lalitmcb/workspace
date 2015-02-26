package com.lalit.kafkaStormIntegration.storm;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

public class PrintTextBolt extends BaseBasicBolt {

	public void execute(Tuple tuple, BasicOutputCollector collector) {
		System.out.println("Size of tuple: " + tuple.size());
		String text = tuple.getString(0);
		System.out.println("Text: " + text);
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {

	}

}
