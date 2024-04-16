var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":91,"id":2318,"methods":[{"el":45,"sc":5,"sl":42},{"el":53,"sc":5,"sl":50},{"el":67,"sc":5,"sl":55},{"el":81,"sc":5,"sl":69},{"el":90,"sc":5,"sl":83}],"name":"MarkdownParserTest","sl":34}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_30":{"methods":[{"sl":55},{"sl":83}],"name":"shouldParseToHtml","pass":true,"statements":[{"sl":57},{"sl":58},{"sl":59},{"sl":60},{"sl":61},{"sl":84},{"sl":88}]},"test_68":{"methods":[{"sl":69},{"sl":83}],"name":"shouldParseSnippetToHtml","pass":true,"statements":[{"sl":71},{"sl":72},{"sl":73},{"sl":74},{"sl":75},{"sl":84},{"sl":88}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [30], [], [30], [30], [30], [30], [30], [], [], [], [], [], [], [], [68], [], [68], [68], [68], [68], [68], [], [], [], [], [], [], [], [30, 68], [30, 68], [], [], [], [30, 68], [], [], []]