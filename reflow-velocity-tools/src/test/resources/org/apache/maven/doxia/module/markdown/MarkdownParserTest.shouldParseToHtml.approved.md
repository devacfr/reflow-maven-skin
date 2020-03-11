<html>
 <head>
  <title>H1</title>
 </head>
 <body>
  <h1>H1</h1>
  <h2>H2</h2>
  <h3>H3</h3>
  <h4>H4</h4>
  <h5>H5</h5>
  <h6>H6</h6>
  <p>Alternatively, for H1 and H2, an underline-ish style:</p>
  <h1>Alt-H1</h1>
  <h2>Alt-H2</h2>
  <h2>Emphasis</h2>
  <p>Emphasis, aka italics, with <em>asterisks</em> or <em>underscores</em>.</p>
  <p>Strong emphasis, aka bold, with <strong>asterisks</strong> or <strong>underscores</strong>.</p>
  <p>Combined emphasis with <strong>asterisks and <em>underscores</em></strong>.</p>
  <p>Strikethrough uses two tildes. <del>Scratch this.</del></p>
  <p>code in paragraph <code>&lt;div cleas="border-line"&gt;&lt;/div&gt;</code>.</p>
  <h2>Lists</h2>
  <ol> 
   <li>First ordered list item</li>
   <li>Another item ⋅⋅* Unordered sub-list.</li>
   <li>Actual numbers don’t matter, just that it’s a number ⋅⋅1. Ordered sub-list</li>
   <li>And another item.</li> 
  </ol>
  <p>⋅⋅⋅You can have properly indented paragraphs within list items. Notice the blank line above, and the leading spaces (at least one, but we’ll use three here to also align the raw Markdown).</p>
  <p>⋅⋅⋅To have a line break without a paragraph, you will need to use two trailing spaces.⋅⋅ ⋅⋅⋅Note that this line is separate, but within the same paragraph.⋅⋅ ⋅⋅⋅(This is contrary to the typical GFM line break behaviour, where trailing spaces are not required.)</p>
  <ul> 
   <li>Unordered list can use asterisks</li>
   <li>Or minuses</li>
   <li>Or pluses</li> 
  </ul>
  <h2>Links</h2>
  <p><a href="https://www.google.com">I’m an inline-style link</a></p>
  <p><a href="https://www.google.com" title="Google's Homepage">I’m an inline-style link with title</a></p>
  <p><a href="https://www.mozilla.org">I’m a reference-style link</a></p>
  <p><a href="../blob/master/LICENSE">I’m a relative reference to a repository file</a></p>
  <p><a href="http://slashdot.org">You can use numbers for reference-style link definitions</a></p>
  <p>Or leave it empty and use the <a href="http://www.reddit.com">link text itself</a>.</p>
  <p>URLs and URLs in angle brackets will automatically get turned into links. <a href="http://www.example.com">http://www.example.com</a> or <a href="http://www.example.com">http://www.example.com</a> and sometimes example.com (but not on Github, for example).</p>
  <p>Some text to show that the reference links can follow later.</p>
  <h2>Images</h2>
  <p>Here’s our logo (hover to see the title text):</p>
  <p>Inline-style: <img src="https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png" alt="alt text" title="Logo Title Text 1"></p>
  <p>Reference-style: <img src="https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png" alt="alt text" title="Logo Title Text 2"></p>
  <h2>Code and Syntax Highlighting</h2>
  <p>Inline <code>code</code> has <code>back-ticks around</code> it.</p> 
  <div class="source">
   <pre>var s = "JavaScript syntax highlighting";
alert(s);
</pre>
  </div> 
  <div class="source">
   <pre>s = "Python syntax highlighting"
print s
</pre>
  </div> 
  <div class="source">
   <pre>No language indicated, so no syntax highlighting. 
But let's throw in a &lt;b&gt;tag&lt;/b&gt;.
</pre>
  </div> 
  <h2>Tables</h2>
  <p>Colons can be used to align columns.</p>
  <table> 
   <thead> 
    <tr>
     <th> Tables </th>
     <th align="center"> Are </th>
     <th align="right"> Cool </th>
    </tr> 
   </thead>
   <tbody> 
    <tr>
     <td> col 3 is </td>
     <td align="center"> right-aligned </td>
     <td align="right"> $1600 </td>
    </tr>
    <tr>
     <td> col 2 is </td>
     <td align="center"> centered </td>
     <td align="right"> $12 </td>
    </tr>
    <tr>
     <td> zebra stripes </td>
     <td align="center"> are neat </td>
     <td align="right"> $1 </td>
    </tr> 
   </tbody> 
  </table>
  <p>There must be at least 3 dashes separating each header cell. The outer pipes (|) are optional, and you don’t need to make the raw Markdown line up prettily. You can also use inline Markdown.</p>
  <table> 
   <thead> 
    <tr>
     <th>Markdown </th>
     <th> Less </th>
     <th> Pretty</th>
    </tr> 
   </thead>
   <tbody> 
    <tr>
     <td><em>Still</em> </td>
     <td> <code>renders</code> </td>
     <td> <strong>nicely</strong></td>
    </tr>
    <tr>
     <td>1 </td>
     <td> 2 </td>
     <td> 3</td>
    </tr> 
   </tbody> 
  </table>
  <h2>Blockquotes</h2>
  <blockquote> 
   <p>Blockquotes are very handy in email to emulate reply text. This line is part of the same quote.</p> 
  </blockquote>
  <p>Quote break.</p>
  <blockquote> 
   <p>This is a very long line that will still be quoted properly when it wraps. Oh boy let’s keep writing to make sure this is long enough to actually wrap for everyone. Oh, you can <em>put</em> <strong>Markdown</strong> into a blockquote.</p> 
  </blockquote>
  <h2>&nbsp;Inline Html</h2> 
  <dl> 
   <dt>
    Definition list
   </dt> 
   <dd>
    Is something people use sometimes.
   </dd> 
   <dt>
    Markdown in HTML
   </dt> 
   <dd>
    Does *not* work **very** well. Use HTML 
    <em>tags</em>.
   </dd> 
  </dl> 
  <h2>Horizontal Rule</h2>
  <p>Three or more…</p>
  <hr>
  <p>Hyphens</p>
  <hr>
  <p>Asterisks</p>
  <hr>
  <p>Underscores</p>
  <h2>&nbsp;Line Breaks</h2>
  <p>Here’s a line for us to start with.</p>
  <p>This line is separated from the one above by two newlines, so it will be a <em>separate paragraph</em>.</p>
  <p>This line is also a separate paragraph, but… This line is only separated by a single newline, so it’s a separate line in the <em>same paragraph</em>.</p>
 </body>
</html>
