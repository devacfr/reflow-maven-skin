# Navside Menu Component

Navside menu component is a part of page [documentation layout][documentation-layout] to the left of page. Navside menu is vertical multi level menus for both desktop and mobile modes initialized with the `<menu>` element declared in a page with documentation layout type.

## Usage

support <span class="badge badge-primary">v2.0</span> <span class="badge badge-success">new</span><br/>
element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">component</span>



```xml
<navside-menu cssClass="bootstrap classes"
              theme="light|dark"
              background="bootstrap colour theme" />
```

- **cssClass** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap support. `navside-light bg-light` is the default value if value is empty or `null`. **note**: `cssClass` override attributes `theme` and `background` if is filled.
- **theme** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap theme . `light` is the default value if value is empty or `null`.
- **background** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap colour theme. `light` is the default value if value is empty or `null`.

[documentation-layout]: #documentation-layout
