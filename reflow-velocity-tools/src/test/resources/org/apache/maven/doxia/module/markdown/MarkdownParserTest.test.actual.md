# Test

## Nested button group with dropdown

{{< layout class="btn-group" role="group" aria-label="Button group with nested dropdown" >}}
{{< bs-button color="secondary" >}}1{{< /bs-button >}}
{{< bs-button color="secondary" >}}2{{< /bs-button >}}
{{< layout class="btn-group" role="group" >}}
{{< bs-button color="secondary" class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" >}}
Dropdown
{{< /bs-button >}}
{{% dropdown %}}
<!--
<item title="Dropdown link" href="#"></item>
<item title="Dropdown link" href="#"></item>
-->
{{% /dropdown %}}

{{< /layout >}}
{{< /layout >}}
