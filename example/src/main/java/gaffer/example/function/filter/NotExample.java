/*
 * Copyright 2016 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gaffer.example.function.filter;


import gaffer.function.simple.filter.AreEqual;
import gaffer.function.simple.filter.Exists;
import gaffer.function.simple.filter.Not;

public class NotExample extends FilterFunctionExample {
    public static void main(final String[] args) {
        new NotExample().run();
    }

    public NotExample() {
        super(Not.class);
    }

    public void runExamples() {
        doesNotExist();
        areNotEqual();
    }

    public void doesNotExist() {
        runExample(new Not(new Exists()),
                "new Not(new Exists())",
                new Object[]{1},
                new Object[]{null},
                new Object[]{""},
                new Object[]{"abc"});
    }

    public void areNotEqual() {
        runExample(new Not(new AreEqual()),
                "new Not(new AreEqual())",
                new Object[]{1, 1.0},
                new Object[]{1, 2},
                new Object[]{2.5, 2.5},
                new Object[]{"", null},
                new Object[]{"abc", "abc"});
    }
}
