var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":69,"id":2128,"methods":[{"el":39,"sc":5,"sl":34},{"el":45,"sc":5,"sl":41},{"el":58,"sc":5,"sl":47},{"el":67,"sc":5,"sl":60}],"name":"MarkdownParserTest","sl":30}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_69":{"methods":[{"sl":47},{"sl":60}],"name":"shouldParseToHtml","pass":true,"statements":[{"sl":49},{"sl":50},{"sl":51},{"sl":52},{"sl":61},{"sl":65}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [69], [], [69], [69], [69], [69], [], [], [], [], [], [], [], [69], [69], [], [], [], [69], [], [], [], []]