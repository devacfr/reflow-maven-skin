var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":111,"id":3489,"methods":[{"el":40,"sc":3,"sl":37},{"el":48,"sc":3,"sl":45},{"el":62,"sc":3,"sl":50},{"el":76,"sc":3,"sl":64},{"el":90,"sc":3,"sl":78},{"el":96,"sc":3,"sl":92},{"el":105,"sc":3,"sl":98},{"el":110,"sc":3,"sl":107}],"name":"MarkdownParserTest","sl":29}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_68":{"methods":[{"sl":50},{"sl":92}],"name":"shouldParseToHtml","pass":true,"statements":[{"sl":52},{"sl":53},{"sl":54},{"sl":55},{"sl":56},{"sl":93},{"sl":94}]},"test_88":{"methods":[{"sl":78},{"sl":92}],"name":"test","pass":true,"statements":[{"sl":80},{"sl":81},{"sl":82},{"sl":83},{"sl":84},{"sl":93},{"sl":94}]},"test_98":{"methods":[{"sl":64},{"sl":92}],"name":"shouldParseSnippetToHtml","pass":true,"statements":[{"sl":66},{"sl":67},{"sl":68},{"sl":69},{"sl":70},{"sl":93},{"sl":94}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [68], [], [68], [68], [68], [68], [68], [], [], [], [], [], [], [], [98], [], [98], [98], [98], [98], [98], [], [], [], [], [], [], [], [88], [], [88], [88], [88], [88], [88], [], [], [], [], [], [], [], [68, 98, 88], [68, 98, 88], [68, 98, 88], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]