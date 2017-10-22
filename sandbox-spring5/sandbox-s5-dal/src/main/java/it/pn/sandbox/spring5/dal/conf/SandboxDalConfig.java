/*
 * File SandboxDalConfig.java of project sandbox-s5-dal.
 * File created on 16 ott 2017 at 14:49:13 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;

/**
 * Class SandboxDalConfig representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Configuration
@Import({ SandboxOracleConfig.class, SandboxMysqlConfig.class })
public class SandboxDalConfig {
    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
	return new HibernateExceptionTranslator();
    }
}
