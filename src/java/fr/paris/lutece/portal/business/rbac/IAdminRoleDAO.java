/*
 * Copyright (c) 2002-2008, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.portal.business.rbac;

import java.util.Collection;


/**
 * AdminRoleDAO Interface
 */
public interface IAdminRoleDAO
{
    /**
     * Check that the given key points to an existing role
     *
     * @param strRoleKey The role key
     * @return true if the role exists, false otherwise
     */
    boolean checkExistRole( String strRoleKey );

    /**
     * Delete a record from the table
     *
     * @param strRoleKey The AdminRole object
     */
    void delete( String strRoleKey );

    /**
     * Insert a new record in the table.
     *
     * @param role The role object
     */
    void insert( AdminRole role );

    /**
     * Load the data of AdminRole from the table
     *
     * @param strRoleKey The identifier of AdminRole
     * @return the instance of the AdminRole
     */
    AdminRole load( String strRoleKey );

    /**
     * Load the list of roles
     *
     * @return The Collection of the Roles
     */
    Collection<AdminRole> selectRoleList(  );

    /**
     * Update the record identified by the given role key with the given role in the table
     *
     * @param strRoleKey the key of the role to modify
     * @param role The reference of role to be the new one
     */
    void store( String strRoleKey, AdminRole role );
}
