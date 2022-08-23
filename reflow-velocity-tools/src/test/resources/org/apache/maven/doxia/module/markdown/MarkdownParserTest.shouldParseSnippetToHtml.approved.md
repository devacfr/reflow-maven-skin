<html>
 <head></head>
 <body>
  <p>element {{&lt; badge color=“secondary” text=“site.xml” /&gt;}}</p>
  <p>{{&lt; example class=“mb-4” &gt;}}</p>
  <p>{{&lt; breadcrumb /&gt;}}</p>
  <p>{{&lt; /example &gt;}}</p>
  <p>Breadcrumbs are defined using standard Maven site element <code>&lt;body&gt;&lt;breadcrumbs&gt;</code> in <code>site.xml</code>. Reflow skin provides a <code>&lt;breadcrumbs&gt;</code> flag to enable/disable them:</p> 
  <pre><code class="language-xml">&lt;breadcrumbs&gt;true|false&lt;/breadcrumbs&gt;
</code></pre>
  <ul> 
   <li><strong>true (default)</strong> - Breadcrumb trail is displayed below the banner</li>
   <li><strong>false</strong> - Do not display breadcrumbs</li> 
  </ul>
  <p>{{&lt; callout title=“Note” level=“5” color=“info” &gt;}}</p>
  <p>The breadcrumbs bar must be enabled if Maven site date or version are set to position <strong>left</strong> or <strong>right</strong>.</p>
  <p>{{&lt; /callout &gt;}}</p>
 </body>
</html>