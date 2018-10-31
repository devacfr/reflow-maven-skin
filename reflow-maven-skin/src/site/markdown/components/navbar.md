# Top Navbar Component

support <span class="badge badge-primary">v2.0</span><br/>
element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">component</span>

Navbar is Bootstrap responsive navigation header component fixed to the top of page. It contains all [`<body><links>` element][site-links] and filtered [`<body><menu>`][site-menus] declared in site.xml.

```xml
<custom>
  <reflowSkin>
    ...
    <!-- global -->
    <navbar filterMenu="Regex filter" cssClass="bootstrap classes" />
    <pages>
        <page>
            <!-- specific one page -->
            <navbar cssClass="bootstrap classes" />
        </page>
    </pages>
    ...
  </reflowSkin>
</custom>
```

- **filterMenu** <span class="badge badge-light">v2.0</span> - applies the regular expression to menu names and `ref` attributes. If the regular expression matches, adds the menu to the top navigation.
    expression matches, adds the menu to the top navigation.
- **cssClass** <span class="badge badge-light">v2.0</span> - Sets the css class of navbar with built-in Bootstrap support. `navbar-light bg-light` is the default value if value is empty or `null`.

[site-menus]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Including_Generated_Content
[site-links]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Links
