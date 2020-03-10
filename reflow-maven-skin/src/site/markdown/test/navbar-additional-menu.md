# Navbar Additional Menu
  
```xml
<custom>
  <reflowSkin>
    ...
    <page>
        <navbar filterMenu="inherit" theme="light" background="light" cssClass="border-bottom" center="false" alignMenu="left">
            <image src="$resourcePath/images/logo.svg" />
            <additionalMenu>
              <![CDATA[
                <ul class="navbar-nav navbar-additional ml-md-auto">
                  <li class="nav-item dropdown">
                  <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="m-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      v2.3
                  </a>
                  <div class="dropdown-menu dropdown-menu-md-right" aria-labelledby="bd-versions">
                      <a class="dropdown-item active" href="#">Latest (2.3.x)</a>
                      <a class="dropdown-item" href="#">v2.1.1</a>
                      <a class="dropdown-item" href="#">v2.0.0</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">v1.5.1</a>
                      <a class="dropdown-item" href="d#">v1.4.0</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">All versions</a>
                  </div>
                  </li>
                  <li class="nav-item">
                      <a href="#" class="p-2 text-secondary"><i class="fab fa-lg fa-github" style="line-height: 1.75em;"></i></a>
                  </li>
                  <li class="nav-item">
                      <a href="#" class="p-2 text-secondary"><i class="fab fa-lg fa-twitter" style="line-height: 1.75em;"></i></a>
                  </li>
                </ul>
                ]]>
            </additionalMenu>
        </navbar>
    </page>
    ...
  </reflowSkin>
</custom>
```

Find other options for Reflow Maven skin [here][reflow-navbar].

[site-xml]: http://maven.apache.org/doxia/doxia-sitetools/doxia-decoration-model/decoration.html
[reflow-navbar]: ../reflow-documentation.html#components-navbar
