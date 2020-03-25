var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":94,"id":2718,"methods":[{"el":40,"sc":5,"sl":30},{"el":52,"sc":5,"sl":42},{"el":64,"sc":5,"sl":54},{"el":76,"sc":5,"sl":66},{"el":88,"sc":5,"sl":78},{"el":92,"sc":5,"sl":90}],"name":"SnippetParserTest","sl":25}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":30},{"sl":90}],"name":"shouldReplaceSnippetByHtml","pass":true,"statements":[{"sl":32},{"sl":33},{"sl":34},{"sl":91}]},"test_22":{"methods":[{"sl":66},{"sl":90}],"name":"shouldRenderLayout","pass":true,"statements":[{"sl":68},{"sl":69},{"sl":70},{"sl":91}]},"test_26":{"methods":[{"sl":78},{"sl":90}],"name":"shouldRenderNestedComponent","pass":true,"statements":[{"sl":80},{"sl":81},{"sl":82},{"sl":91}]},"test_54":{"methods":[{"sl":54},{"sl":90}],"name":"shouldRenderBadge","pass":true,"statements":[{"sl":56},{"sl":57},{"sl":58},{"sl":91}]},"test_64":{"methods":[{"sl":42},{"sl":90}],"name":"shouldRenderCard","pass":true,"statements":[{"sl":44},{"sl":45},{"sl":46},{"sl":91}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [1], [], [1], [1], [1], [], [], [], [], [], [], [], [64], [], [64], [64], [64], [], [], [], [], [], [], [], [54], [], [54], [54], [54], [], [], [], [], [], [], [], [22], [], [22], [22], [22], [], [], [], [], [], [], [], [26], [], [26], [26], [26], [], [], [], [], [], [], [], [1, 54, 22, 26, 64], [1, 54, 22, 26, 64], [], [], []]