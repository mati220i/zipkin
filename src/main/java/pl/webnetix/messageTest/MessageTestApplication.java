package pl.webnetix.messageTest;

//import com.netflix.appinfo.InstanceInfo;
//import com.netflix.discovery.EurekaClient;
import org.apache.log4j.BasicConfigurator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.sleuth.metric.SpanMetricReporter;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import zipkin.Span;
//import org.springframework.cloud.sleuth.zipkin.*;

@SpringBootApplication(scanBasePackages = {"pl.webnetix.messages.persistence.repositories"})
@EnableAutoConfiguration
@EnableJpaRepositories(value = "pl.webnetix.messages.persistence.repositories")
@EntityScan(basePackages = {"pl.webnetix.messages.persistence.entities"})
@ComponentScan(value = {"pl.webnetix.messages.persistence.repositories", "pl.webnetix.messageTest.web", "pl.webnetix.messages.logic"})//, "org.springframework.cloud.sleuth.metric.SpanMetricReporter"})
//@EnableDiscoveryClient
public class MessageTestApplication {

//	@Qualifier("eurekaClient")
//	@Autowired
//	private EurekaClient eurekaClient;
//
//	@Autowired
//	private SpanMetricReporter spanMetricReporter;
//
//	@Autowired
//	private ZipkinProperties zipkinProperties;
//
//	@Value("${spring.sleuth.web.skipPattern}")
//	private String skipPattern;

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(MessageTestApplication.class, args);
	}

//	@Bean
//	public ZipkinSpanReporter makeZipkinSpanReporter() {
//		return new ZipkinSpanReporter() {
//			private HttpZipkinSpanReporter delegate;
//			private String baseUrl;
//
//			@Override
//			public void report(Span span) {
//				InstanceInfo instance = eurekaClient.getNextServerFromEureka("zipkin", false);
//				if (!(baseUrl != null && instance.getHomePageUrl().equals(baseUrl))) {
//					baseUrl = instance.getHomePageUrl();
//					delegate = new HttpZipkinSpanReporter(baseUrl, zipkinProperties.getFlushInterval(), zipkinProperties.getCompression().isEnabled(), spanMetricReporter);
//					if (!span.name.matches(skipPattern)) delegate.report(span);
//				}
//			}
//		};
//	}

}
