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


/**
 * 
 * @author wb-zmx300072
 * @since 5.0
 */
public class MytestBean {

    public static void main(String[] args) {
/*        testMethod("a","b");
        testMethod("a","b","c");
        testMethod("a","b","d");*/
        String[] arrStr = {"d","e","f"};
        testMethod("a","b",arrStr);
    }

    public static void testMethod(String opt1,String opt2,String... opt){

        if(opt!= null && opt.length>0){
            for (int i=0;i<opt.length;i++){
                System.out.println(opt[i]);
            }
        }

    }

}
