var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":94,"id":2654,"methods":[{"el":44,"sc":5,"sl":30},{"el":60,"sc":5,"sl":46},{"el":76,"sc":5,"sl":62},{"el":92,"sc":5,"sl":78}],"name":"SnippetParserTest","sl":25}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_12":{"methods":[{"sl":30}],"name":"shouldReplaceSnippetByHtml","pass":true,"statements":[{"sl":32},{"sl":33},{"sl":34},{"sl":35},{"sl":37},{"sl":38}]},"test_16":{"methods":[{"sl":46}],"name":"shouldRenderCard","pass":true,"statements":[{"sl":48},{"sl":49},{"sl":50},{"sl":51},{"sl":53},{"sl":54}]},"test_42":{"methods":[{"sl":78}],"name":"shouldRenderLayout","pass":true,"statements":[{"sl":80},{"sl":81},{"sl":82},{"sl":83},{"sl":85},{"sl":86}]},"test_48":{"methods":[{"sl":62}],"name":"shouldRenderBadge","pass":true,"statements":[{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":69},{"sl":70}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [12], [], [12], [12], [12], [12], [], [12], [12], [], [], [], [], [], [], [], [16], [], [16], [16], [16], [16], [], [16], [16], [], [], [], [], [], [], [], [48], [], [48], [48], [48], [48], [], [48], [48], [], [], [], [], [], [], [], [42], [], [42], [42], [42], [42], [], [42], [42], [], [], [], [], [], [], [], []]