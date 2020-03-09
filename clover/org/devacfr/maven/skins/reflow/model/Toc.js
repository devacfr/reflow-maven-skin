var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":195,"id":1491,"methods":[{"el":93,"sc":5,"sl":63},{"el":102,"sc":5,"sl":100},{"el":111,"sc":5,"sl":109},{"el":122,"sc":5,"sl":119},{"el":130,"sc":5,"sl":127},{"el":137,"sc":5,"sl":135},{"el":146,"sc":5,"sl":144},{"el":161,"sc":5,"sl":154},{"el":173,"sc":5,"sl":170},{"el":186,"sc":5,"sl":175},{"el":194,"sc":5,"sl":191}],"name":"Toc","sl":42}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_17":{"methods":[{"sl":100},{"sl":119},{"sl":127},{"sl":144},{"sl":170}],"name":"shouldBuildFrameContext","pass":true,"statements":[{"sl":101},{"sl":120},{"sl":121},{"sl":129},{"sl":145},{"sl":171},{"sl":172}]},"test_21":{"methods":[{"sl":63},{"sl":109},{"sl":119},{"sl":127},{"sl":144},{"sl":170}],"name":"shouldBuildPageContext","pass":true,"statements":[{"sl":64},{"sl":65},{"sl":66},{"sl":69},{"sl":70},{"sl":73},{"sl":76},{"sl":80},{"sl":81},{"sl":82},{"sl":92},{"sl":110},{"sl":120},{"sl":121},{"sl":129},{"sl":145},{"sl":171},{"sl":172}]},"test_9":{"methods":[{"sl":63},{"sl":119},{"sl":127},{"sl":144},{"sl":170}],"name":"shouldBuildPageContextWithTocDisabled","pass":true,"statements":[{"sl":64},{"sl":65},{"sl":66},{"sl":69},{"sl":70},{"sl":71},{"sl":73},{"sl":74},{"sl":76},{"sl":83},{"sl":85},{"sl":88},{"sl":89},{"sl":92},{"sl":120},{"sl":121},{"sl":129},{"sl":145},{"sl":171},{"sl":172}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [9, 21], [9, 21], [9, 21], [9, 21], [], [], [9, 21], [9, 21], [9], [], [9, 21], [9], [], [9, 21], [], [], [], [21], [21], [21], [9], [], [9], [], [], [9], [9], [], [], [9, 21], [], [], [], [], [], [], [], [17], [17], [], [], [], [], [], [], [], [21], [21], [], [], [], [], [], [], [], [], [17, 9, 21], [17, 9, 21], [17, 9, 21], [], [], [], [], [], [17, 9, 21], [], [17, 9, 21], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [17, 9, 21], [17, 9, 21], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [17, 9, 21], [17, 9, 21], [17, 9, 21], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]