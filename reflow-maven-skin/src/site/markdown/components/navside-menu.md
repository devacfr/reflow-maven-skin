# Navside Menu Component

support <span class="badge badge-primary">v2.0</span><br/>
element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">component</span>

Navside menu component fixed to the left of page. It is a part of document page.

```xml
<custom>
  <reflowSkin>
    ...
    <!-- global -->
    <navside-menu cssClass="bootstrap classes" />
    <pages>
        <page>
            <!-- specific one page -->
            <navside-menu cssClass="bootstrap classes" />
        </page>
    </pages>
    ...
  </reflowSkin>
</custom>
```

- **cssClass** <span class="badge badge-light">v2.0</span> - Sets the css class of navside menu with built-in Bootstrap support. `navside-light bg-light` is the default value if value is empty or `null`.
