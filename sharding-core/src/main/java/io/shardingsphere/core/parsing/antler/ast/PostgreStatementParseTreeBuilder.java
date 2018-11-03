/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package io.shardingsphere.core.parsing.antler.ast;

import io.shardingsphere.core.parsing.antler.parser.PostgreStatementAdvancedParser;
import io.shardingsphere.parser.antlr.PostgreStatementLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;

/**
 * Postgre tree builder.
 * 
 * @author duhongjun
 */
public final class PostgreStatementParseTreeBuilder extends AbstractParseTreeBuilder {
    
    @Override
    protected Lexer newLexer(final CharStream charStream) {
        return new PostgreStatementLexer(charStream);
    }
    
    @Override
    protected Parser newParser(final TokenStream tokenStream) {
        return new PostgreStatementAdvancedParser(tokenStream);
    }
    
    @Override
    protected ParserRuleContext getParserTree(final Parser parser) {
        PostgreStatementAdvancedParser parse = (PostgreStatementAdvancedParser) parser;
        return parse.execute();
    }
}