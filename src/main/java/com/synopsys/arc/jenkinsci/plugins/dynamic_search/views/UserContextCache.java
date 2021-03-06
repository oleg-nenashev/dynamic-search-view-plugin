/*
 * The MIT License
 *
 * Copyright 2013-2015 Oleg Nenashev, Synopsys Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.synopsys.arc.jenkinsci.plugins.dynamic_search.views;

import static com.synopsys.arc.jenkinsci.plugins.dynamic_search.views.SimpleSearchView.getSessionId;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

/**
 * Stores search sessions for {@link SimpleSearchView}.
 * @author Oleg Nenashev
 * @since 0.2
 */
@Restricted(NoExternalUse.class)
class UserContextCache {
    Map<String, UserContext> contextMap = new HashMap<String, UserContext>();
    
    public synchronized boolean containsKey(String sessionId) {
        return contextMap.containsKey(sessionId);
    }
    
    @CheckForNull
    public synchronized UserContext get(String sessionId) {
        return contextMap.get(sessionId);
    }
    
    public synchronized void flush(String sessionId) {
        if (contextMap.containsKey(sessionId)) {
            contextMap.remove(sessionId);
        }      
    }
    
    public synchronized void put (String sessionId, UserContext context) {
        contextMap.put(getSessionId(), context);
    } 
}
