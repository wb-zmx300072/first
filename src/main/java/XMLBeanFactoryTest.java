/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


/**
 * 
 * @author wb-zmx300072
 * @since 5.0
 */
public class XMLBeanFactoryTest {
	

	public static void main(String[] args) {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		MytestBean mb = (MytestBean)bf.getBean("myTestBean");
		MytestBean mb1 = (MytestBean)bf.getBean("myTestBean");
		System.out.println(mb);
		System.out.println(mb1);
		System.out.println(mb == mb1);
		Map<String,String> map = new HashMap<String, String>();
		tt(map);
//		Resource resource = new ClassPathResource("beanFactoryTest.xml");
//		InputStream inputStream = resource.getInputStream();
	}



	public static void tt(Map<String,?> map) {
		Map<String,String> newMap = (Map<String,String>)map;
		System.out.println("map = [" + newMap + "]");
	}
}
