var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":77,"id":1828,"methods":[{"el":37,"sc":5,"sl":35},{"el":43,"sc":5,"sl":42},{"el":57,"sc":5,"sl":48},{"el":66,"sc":5,"sl":64},{"el":75,"sc":5,"sl":73}],"name":"Components","sl":26}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_2":{"methods":[{"sl":42},{"sl":48}],"name":"shouldRenderLayout","pass":true,"statements":[{"sl":49},{"sl":50},{"sl":51},{"sl":52},{"sl":54},{"sl":56}]},"test_4":{"methods":[{"sl":42},{"sl":48},{"sl":64}],"name":"shouldReplaceSnippetByHtml","pass":true,"statements":[{"sl":49},{"sl":50},{"sl":51},{"sl":52},{"sl":54},{"sl":56},{"sl":65}]},"test_42":{"methods":[{"sl":42}],"name":"shouldRenderBadge","pass":true,"statements":[]},"test_46":{"methods":[{"sl":42},{"sl":48},{"sl":64}],"name":"shouldRenderCard","pass":true,"statements":[{"sl":49},{"sl":50},{"sl":51},{"sl":52},{"sl":54},{"sl":56},{"sl":65}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [42, 46, 2, 4], [], [], [], [], [], [46, 2, 4], [46, 2, 4], [46, 2, 4], [46, 2, 4], [46, 2, 4], [], [46, 2, 4], [], [46, 2, 4], [], [], [], [], [], [], [], [46, 4], [46, 4], [], [], [], [], [], [], [], [], [], [], [], []]