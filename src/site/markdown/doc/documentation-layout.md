# Page Documentation layout

Documentation layout is a feature to organize your documentation in single page to facilitate the navigation.

The layout is centered on a `navside` menu. Navside menu is vertical multi level menus for both desktop and mobile modes initialized with the `<menu>` element declared in a page with documentation layout type and a `frame` container where will be displayed the contain of each `frame` page.

![documentation layout](../images/doc/documentation-layout-scheme.png)

- [**Navside menu** can be customized][navside] as all other components in Reflow. It is created using `<menu>` element defined in documentation layout page.
- **Frame container** allows to load the `frame` page. The `frame` type is for internal use to define referenced page in `<menu>` element in documentation layout. A `frame` page shouldn't use outside of documentation layout page where it is declared.

## Usage

support <span class="badge badge-primary">v2.0</span><br/>
element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">element</span>

To declare a page as documentation layout, create an empty page (`documentation.html` in example below) and set `type` attribute with value `doc` and add a **required** `<menu>` element as example below.

```xml
<pages>
    ...
    <documentation type="doc" project="project-id">
        <menu name="Documentation" selectFirstOnExpand="true|false">
            <item name="One page" href="one-page.html" />
            <item name="First level" >
                <item name="Second level" href="second-level.html"/>
            </item>
        </menu>
    </documentation>
    ...
</pages>
```

- **project** <span class="badge badge-light">v1.0</span> - `project` attribute associates the page to specific Maven artifactId declaring in the project. This can be useful to exclude all inherit configuration on same page name localized in other module in project. **Be careful** that `name` attribute in root `<project>` element in site.xml is used to set the site title.
- **selectFirstOnExpand** <span class="badge badge-light">v2.0</span> - Sets the indicating whether the first child menu item in section item menu (containing children menu items) is selected when click on it. the default value is `true`.

The example above produces the following `navside` menu:

![navside menu preview](../images/doc/navside-menu-preview.png)

<div class="bd-callout bd-callout-warning">
    <h4 class="no-anchor">You are a page in other project module displaying bizarrely</h4>
    <p>This page has maybe the same filename as declared page used in documentation layout. You can resolve this problem by adding <code>project</code> attribute or change the filename of one of the files.</p>
</div>

## Improve documentation

Doxia Sitetools has introduce the edit source feature in [decoration model 1.8][decoration-model] adding `<edit>` element allowing to add link on each document page that points to source file in scm ([DOXIASITETOOLS-183][DOXIASITETOOLS-183]). In general, `${project.scm.url}` value should do the job.

```xml
<project>
    <edit>${project.scm.url}</edit>
</project>
```

![Improve this page](../images/doc/improve-this-page.png)

[DOXIASITETOOLS-183]: https://issues.apache.org/jira/browse/DOXIASITETOOLS-183
[decoration-model]: https://maven.apache.org/doxia/doxia-sitetools/doxia-decoration-model/decoration.html

[navside]: #components-navside-menu
