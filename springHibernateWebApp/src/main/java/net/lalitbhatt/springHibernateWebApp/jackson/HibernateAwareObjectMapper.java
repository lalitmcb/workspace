package net.lalitbhatt.springHibernateWebApp.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * For deatails of this class see the javadoc of MappingJackson2HttpMessageConverter
 * @author Lalit
 *
 */
public class HibernateAwareObjectMapper extends ObjectMapper {
    
    public HibernateAwareObjectMapper() {
        Hibernate4Module hm = new Hibernate4Module();
        registerModule(hm);
    }
}