/*
 * Copyright (c) 2002-2014, Mairie de Paris
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
package fr.paris.lutece.portal.web.xpages;

import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.portal.business.page.Page;
import fr.paris.lutece.portal.business.style.PageTemplateHome;
import fr.paris.lutece.portal.service.page.IPageService;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.portal.PortalService;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.test.LuteceTestCase;
import fr.paris.lutece.test.MokeHttpServletRequest;


/**
 * SiteMap Test Class
 */
public class SiteMapAppTest extends LuteceTestCase
{
    /**
     * Test of getPage method, of class fr.paris.lutece.portal.web.xpages.SiteMapApp.
     */
    public void testGetPage(  )
    {
        System.out.println( "getPage" );

        MokeHttpServletRequest request = new MokeHttpServletRequest(  );

        int nMode = 0;
        Plugin plugin = null;
        SiteMapApp instance = new SiteMapApp(  );

        XPage expResult = null;
        XPage result = instance.getPage( request, nMode, plugin );
    }

    public void testGetPageMod()
    {
        HttpServletRequest request = new MokeHttpServletRequest( );
        // determine a random page name
        String randomPageName = "page" + new SecureRandom( ).nextLong( );
        // get the site map
        SiteMapApp instance = new SiteMapApp(  );
        XPage sitemap = instance.getPage( request, 0, null );
        assertFalse( "Site map should not contain not yet created page with name " + randomPageName, sitemap.getContent( ).contains( randomPageName ) );
        // create the page
        Page page = new Page(  );
        page.setParentPageId( PortalService.getRootPageId(  ) );
        page.setPageTemplateId( PageTemplateHome.getPageTemplatesList( ).get( 0 ).getId( ) );
        page.setName( randomPageName );
        IPageService pageService = (IPageService) SpringContextService.getBean( "pageService" );
        pageService.createPage( page );
        // get the site map
        sitemap = instance.getPage( request, 0, null );
        assertTrue( "Site map should contain page with name " + randomPageName, sitemap.getContent( ).contains( randomPageName ) );
        // change the page name
        randomPageName = randomPageName + "_mod";
        page.setName( randomPageName );
        pageService.updatePage( page );
        // get the site map
        sitemap = instance.getPage( request, 0, null );
        assertTrue( "Site map should contain page with the modified name " + randomPageName, sitemap.getContent( ).contains( randomPageName ) );
        // remove the page
        pageService.removePage( page.getId( ) );
        // get the site map
        sitemap = instance.getPage( request, 0, null );
        assertFalse( "Site map should not contain page with name " + randomPageName + " anymore", sitemap.getContent( ).contains( randomPageName ) );
    }
}
