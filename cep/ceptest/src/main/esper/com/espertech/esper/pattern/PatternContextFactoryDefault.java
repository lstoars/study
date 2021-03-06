/**************************************************************************************
 * Copyright (C) 2008 EsperTech, Inc. All rights reserved.                            *
 * http://esper.codehaus.org                                                          *
 * http://www.espertech.com                                                           *
 * ---------------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the GPL license       *
 * a copy of which has been included with this distribution in the license.txt file.  *
 **************************************************************************************/
package com.espertech.esper.pattern;

import com.espertech.esper.core.context.util.AgentInstanceContext;
import com.espertech.esper.core.service.StatementContext;

/**
 * Default pattern context factory.
 */
public class PatternContextFactoryDefault implements PatternContextFactory
{
    public PatternContext createContext(StatementContext statementContext,
                                        int streamId,
                                        EvalRootFactoryNode rootNode,
                                        MatchedEventMapMeta matchedEventMapMeta,
                                        boolean allowResilient) {
        return new PatternContext(statementContext, streamId, matchedEventMapMeta, false);
    }

    public PatternAgentInstanceContext createPatternAgentContext(PatternContext patternContext, AgentInstanceContext agentInstanceContext, boolean hasConsumingFilter) {
        return new PatternAgentInstanceContext(patternContext, agentInstanceContext, hasConsumingFilter);
    }
}
