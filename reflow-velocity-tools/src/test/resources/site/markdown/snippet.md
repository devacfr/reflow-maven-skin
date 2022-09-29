
# Header

## Inline Short Code

element {{< badget color="primary" text="new" />}}.

## Web component in comment block

{{% component attribute="value" %}}

<!--
<data>
  <data-item class="text-muted" >Header Section</data-item>
  <data-content>
    <div>html used in template</div>
    #include( 'src/site/svg/pretty.svg' )
  </data-content>
</data>
-->

{{% /component%}}

## Web component in markdown code block

{{% component attribute="value" %}}

```
<data>
  <data-item class="text-muted" >Header Section</data-item>
  <data-content>
    <div>html used in template</div>
    #include( 'src/site/svg/pretty.svg' )
  </data-content>
</data>
```

{{% /component%}}