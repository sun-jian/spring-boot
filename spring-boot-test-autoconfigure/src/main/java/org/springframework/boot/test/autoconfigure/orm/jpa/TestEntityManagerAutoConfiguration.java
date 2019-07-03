/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.test.autoconfigure.orm.jpa;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Auto-configuration for {@link TestEntityManager}.
 *
 * @author Phillip Webb
 * @since 1.4.0
 * @see AutoConfigureTestEntityManager
 */
@Configuration
@ConditionalOnClass({ EntityManagerFactory.class })
@AutoConfigureAfter(HibernateJpaAutoConfiguration.class)
public class TestEntityManagerAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public TestEntityManager testEntityManager(EntityManagerFactory entityManagerFactory) {
		return new TestEntityManager(entityManagerFactory);
	}

}
