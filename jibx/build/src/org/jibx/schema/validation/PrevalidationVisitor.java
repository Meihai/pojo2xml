/*
 * Copyright (c) 2006-2009, Dennis M. Sosnoski. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 * disclaimer. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution. Neither the name of
 * JiBX nor the names of its contributors may be used to endorse or promote products derived from this software without
 * specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.jibx.schema.validation;

import org.jibx.schema.SchemaVisitor;
import org.jibx.schema.elements.SchemaBase;

/**
 * Visitor for handling prevalidation. This just calls the
 * {@link org.jibx.schema.elements.SchemaBase#prevalidate(ValidationContext)} method for each element visited, in
 * preorder (parent before children).
 */
public class PrevalidationVisitor extends SchemaVisitor
{
    /** Validation context. */
    private final ValidationContext m_context;
    
    /**
     * Constructor.
     * 
     * @param context
     */
    public PrevalidationVisitor(ValidationContext context) {
        m_context = context;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jibx.binding.model.ModelVisitor#visit(org.jibx.binding.model.ElementBase)
     */
    public boolean visit(SchemaBase node) {
        try {
            node.prevalidate(m_context);
        } catch (Throwable t) {
            m_context.addFatal("Error during validation: " + t.getMessage(), node);
            t.printStackTrace();
            return false;
        }
        return true;
    }
}