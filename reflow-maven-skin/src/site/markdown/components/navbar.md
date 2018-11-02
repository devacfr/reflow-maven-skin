# Top Navbar Component

support <span class="badge badge-primary">v2.0</span><br/>
element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">component</span>

Navbar is Bootstrap responsive navigation header component fixed to the top of page. It contains all [`<body><links>` element][site-links] and filtered [`<body><menu>`][site-menus] declared in site.xml.

```xml
<navbar filterMenu="Regex filter"
        cssClass="bootstrap classes"
        theme="light|dark"
        background="bootstrap colour theme" />
```

- **filterMenu** <span class="badge badge-light">v2.0</span> - applies the regular expression to menu names and `ref` attributes. If the regular expression matches, adds the menu to the top navigation.
    expression matches, adds the menu to the top navigation.
- **cssClass** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap support. `navbar-light bg-light` is the default value if value is empty or `null`. **note**: `cssClass` override attributes `theme` and `background` if is filled.
- **theme** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap theme . `light` is the default value if value is empty or `null`.
- **background** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap colour theme. `light` is the default value if value is empty or `null`.

[site-menus]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Including_Generated_Content
[site-links]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Links
