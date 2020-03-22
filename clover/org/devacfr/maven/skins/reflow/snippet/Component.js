var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":273,"id":1630,"methods":[{"el":89,"sc":5,"sl":70},{"el":97,"sc":5,"sl":94},{"el":104,"sc":5,"sl":102},{"el":112,"sc":5,"sl":109},{"el":119,"sc":5,"sl":117},{"el":129,"sc":5,"sl":124},{"el":136,"sc":5,"sl":134},{"el":143,"sc":5,"sl":141},{"el":156,"sc":5,"sl":149},{"el":186,"sc":5,"sl":162},{"el":190,"sc":5,"sl":188},{"el":197,"sc":5,"sl":195},{"el":205,"sc":5,"sl":199},{"el":219,"sc":5,"sl":207},{"el":224,"sc":5,"sl":221},{"el":233,"sc":5,"sl":226},{"el":242,"sc":5,"sl":239},{"el":251,"sc":5,"sl":248},{"el":259,"sc":5,"sl":256},{"el":272,"sc":5,"sl":264}],"name":"Component","sl":41}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_24":{"methods":[{"sl":70},{"sl":94},{"sl":102},{"sl":124},{"sl":149},{"sl":162},{"sl":188},{"sl":207},{"sl":221},{"sl":239},{"sl":248},{"sl":256},{"sl":264}],"name":"shouldRenderCard","pass":true,"statements":[{"sl":73},{"sl":74},{"sl":76},{"sl":77},{"sl":79},{"sl":82},{"sl":83},{"sl":86},{"sl":95},{"sl":96},{"sl":103},{"sl":125},{"sl":126},{"sl":128},{"sl":150},{"sl":151},{"sl":153},{"sl":155},{"sl":163},{"sl":164},{"sl":166},{"sl":167},{"sl":171},{"sl":176},{"sl":177},{"sl":179},{"sl":182},{"sl":185},{"sl":189},{"sl":208},{"sl":209},{"sl":210},{"sl":211},{"sl":212},{"sl":214},{"sl":216},{"sl":217},{"sl":218},{"sl":222},{"sl":223},{"sl":240},{"sl":241},{"sl":249},{"sl":250},{"sl":258},{"sl":266}]},"test_33":{"methods":[{"sl":70},{"sl":94},{"sl":102},{"sl":124},{"sl":149},{"sl":188},{"sl":207},{"sl":221},{"sl":239},{"sl":248},{"sl":256},{"sl":264}],"name":"shouldRenderLayout","pass":true,"statements":[{"sl":73},{"sl":74},{"sl":76},{"sl":77},{"sl":82},{"sl":83},{"sl":86},{"sl":95},{"sl":96},{"sl":103},{"sl":125},{"sl":126},{"sl":128},{"sl":150},{"sl":153},{"sl":155},{"sl":189},{"sl":208},{"sl":209},{"sl":210},{"sl":211},{"sl":212},{"sl":214},{"sl":216},{"sl":217},{"sl":218},{"sl":222},{"sl":223},{"sl":240},{"sl":241},{"sl":249},{"sl":250},{"sl":258},{"sl":266}]},"test_34":{"methods":[{"sl":70},{"sl":94},{"sl":102},{"sl":124},{"sl":149},{"sl":162},{"sl":188},{"sl":207},{"sl":221},{"sl":239},{"sl":248},{"sl":256},{"sl":264}],"name":"shouldReplaceSnippetByHtml","pass":true,"statements":[{"sl":73},{"sl":74},{"sl":76},{"sl":77},{"sl":82},{"sl":83},{"sl":86},{"sl":95},{"sl":96},{"sl":103},{"sl":125},{"sl":126},{"sl":128},{"sl":150},{"sl":151},{"sl":153},{"sl":155},{"sl":163},{"sl":164},{"sl":166},{"sl":167},{"sl":171},{"sl":172},{"sl":173},{"sl":174},{"sl":176},{"sl":177},{"sl":179},{"sl":182},{"sl":185},{"sl":189},{"sl":208},{"sl":209},{"sl":210},{"sl":211},{"sl":212},{"sl":214},{"sl":216},{"sl":217},{"sl":218},{"sl":222},{"sl":223},{"sl":240},{"sl":241},{"sl":249},{"sl":250},{"sl":258},{"sl":266}]},"test_58":{"methods":[{"sl":94},{"sl":102},{"sl":162},{"sl":188},{"sl":239},{"sl":248},{"sl":256}],"name":"shouldRenderBadge","pass":true,"statements":[{"sl":95},{"sl":96},{"sl":103},{"sl":163},{"sl":164},{"sl":166},{"sl":167},{"sl":189},{"sl":240},{"sl":241},{"sl":249},{"sl":250},{"sl":258}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [24, 34, 33], [], [], [24, 34, 33], [24, 34, 33], [], [24, 34, 33], [24, 34, 33], [], [24], [], [], [24, 34, 33], [24, 34, 33], [], [], [24, 34, 33], [], [], [], [], [], [], [], [24, 34, 33, 58], [24, 34, 33, 58], [24, 34, 33, 58], [], [], [], [], [], [24, 34, 33, 58], [24, 34, 33, 58], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [24, 34, 33], [24, 34, 33], [24, 34, 33], [], [24, 34, 33], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [24, 34, 33], [24, 34, 33], [24, 34], [], [24, 34, 33], [], [24, 34, 33], [], [], [], [], [], [], [24, 34, 58], [24, 34, 58], [24, 34, 58], [], [24, 34, 58], [24, 34, 58], [], [], [], [24, 34], [34], [34], [34], [], [24, 34], [24, 34], [], [24, 34], [], [], [24, 34], [], [], [24, 34], [], [], [24, 34, 33, 58], [24, 34, 33, 58], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [24, 34, 33], [24, 34, 33], [24, 34, 33], [24, 34, 33], [24, 34, 33], [24, 34, 33], [], [24, 34, 33], [], [24, 34, 33], [24, 34, 33], [24, 34, 33], [], [], [24, 34, 33], [24, 34, 33], [24, 34, 33], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [24, 34, 33, 58], [24, 34, 33, 58], [24, 34, 33, 58], [], [], [], [], [], [], [24, 34, 33, 58], [24, 34, 33, 58], [24, 34, 33, 58], [], [], [], [], [], [24, 34, 33, 58], [], [24, 34, 33, 58], [], [], [], [], [], [24, 34, 33], [], [24, 34, 33], [], [], [], [], [], [], []]