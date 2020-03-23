# Twitter Feed

{{< badge color="primary" text="New in v2.4" />}}

{{< badge color="info" text="SHORTCODE" />}}

## Example

{{< example >}}

{{< twitter-feed feed="getbootstrap" text="Tweets By Bootstrap" />}}

{{< /example >}}

```xml
{{< twitter-feed feed="getbootstrap" text="Tweets By Bootstrap" />}}
```

## Custom chrome

Control the frame around the linear timeline by setting a data-chrome attribute with space-separated tokens for each chrome component.

| Attributes    | Description                                                                                                                                                            |
|---------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `noheader`    | Hides the timeline header. Implementing sites must add their own Twitter attribution, link to the source timeline, and comply with other Twitter display requirements. |
| `nofooter`    | Hides the timeline footer and Tweet composer link, if included in the timeline widget type.                                                                            |
| `noborders`   | Removes all borders within the widget including borders surrounding the widget area and separating Tweets.                                                             |
| `noscrollbar` | Crops and hides the main timeline scrollbar, if visible. Please consider that hiding standard user interface components can affect the accessibility of your website.  |
| `transparent` | Removes the widget’s background color.                                                                                                                                 |

{{< example >}}

{{< twitter-feed feed="getbootstrap" text="Tweets By Bootstrap" nofooter noborders theme="dark" />}}

{{< /example >}}

```xml
{{< twitter-feed feed="getbootstrap" text="Tweets By Bootstrap" nofooter noborders theme="dark" />}}
```

## Dimensions

{{< example >}}

{{< twitter-feed feed="getbootstrap" text="Tweets By Bootstrap" width="600" height="300" />}}

{{< /example >}}

```xml
{{< twitter-feed feed="getbootstrap" text="Tweets By Bootstrap" width="600" height="300" />}}
```

## Limiting the number of Tweets displayed

Display a specific number of items between 1 and 20 by customizing your embed HTML.
Add a `tweet-limit` attribute to the embed code to specify a number of Tweets. The timeline will automatically adjust its height to display specified number of Tweets. The timeline is fixed after display; it will not poll for new Tweets.

{{< example >}}

{{< twitter-feed feed="getbootstrap" text="Tweets By Bootstrap" tweet-limit="3" height="300" />}}

{{< /example >}}

```xml
{{< twitter-feed feed="getbootstrap" text="Tweets By Bootstrap" tweet-limit="3" height="300" />}}
```
