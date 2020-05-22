/*
 * Cardinal-Components-API
 * Copyright (C) 2019-2020 OnyxStudios
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */
package nerdhub.cardinal.componentstest.vita;

import nerdhub.cardinal.components.api.ComponentRegistry;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.component.Component;
import nerdhub.cardinal.componentstest.TestStaticComponentInitializer;

public interface Vita extends Component {
    ComponentType<Vita> TYPE = ComponentRegistry.INSTANCE.registerIfAbsent(TestStaticComponentInitializer.VITA_ID, Vita.class);
    ComponentType<Vita> ALT_TYPE = ComponentRegistry.INSTANCE.registerIfAbsent(TestStaticComponentInitializer.ALT_VITA_ID, Vita.class);

    int getVitality();
    void setVitality(int value);
    default void transferTo(Vita dest, int amount) {
        int sourceVitality = this.getVitality();
        int actualAmount = Math.min(sourceVitality, amount);
        this.setVitality(sourceVitality - actualAmount);
        dest.setVitality(dest.getVitality() + actualAmount);
    }
}

