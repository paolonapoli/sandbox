/*
 * File SandboxServiceConfig.java of project sandbox-s5-service.
 * File created on 16 ott 2017 at 19:29:13 at PN-HQ.
 */
package it.pn.sandbox.spring5.service.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Class SandboxServiceConfig representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Configuration
// @Import(SandboxDalConfig.class)
@ComponentScan(basePackages = { "it.pn.sandbox.spring5.service.impl" })
public class SandboxServiceConfig {
}
