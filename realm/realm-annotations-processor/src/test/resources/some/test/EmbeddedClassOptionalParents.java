/*
 * Copyright 2020 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package some.test;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

@RealmClass(embedded = true)
public class EmbeddedClassOptionalParents extends RealmObject {
    public String name;
    public int age;

    // If multiple @LinkingObjects are defined
    // They are not treated as @Required.
    // This mostly impact Kotlin model classes
    @LinkingObjects("child3")
    public final EmbeddedClassParent parent1 = new EmbeddedClassParent(); // Field must be final, because parent cannot change once set

    @LinkingObjects("child4")
    public final EmbeddedClassParent parent2 = new EmbeddedClassParent(); // Field must be final, because parent cannot change once set
}
