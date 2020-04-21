<#assign textEditorName = "fr.paris.lutece.portal.service.editor.RichTextEditorFrontOfficeMethod"?new()() >

<#if textEditorName?has_content>
	<#assign importUrl = "/util/editor/editor_" + textEditorName + ".ftl">
	<#include importUrl />
<#else>
	<#macro initEditor>
		<#-- rich text editor disabled -->
	</#macro>
</#if>