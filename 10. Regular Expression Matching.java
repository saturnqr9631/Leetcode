class Solution {
    public boolean isMatch(String s, String p) {
        if (s.indexOf('*') >= 0) {
            return false;
        }
        if (containSpChar(p)) {
            return isMatchSp(s, p);
        } else {
            return isMatchNorm(s, p);
        }
    }

    private boolean containSpChar(String p) {
        return p.indexOf('*') >= 0 || p.indexOf('.') >= 0;
    }

    private boolean isMatchNorm(String s, String p) {
        return s.equals(p);

    }

    private boolean isMatchSp(String s, String p) {
        boolean result = true;
        boolean hasNextPattern = false;

        char currentCh = 'a';
        char patternCh = 'a';
        char prevPatternCh = 'a';
        char nextPatternCh = 'a';

        int pPos = 0;
        int sPos = 0;
        int pLimit = p.length();
        int sLimit = s.length();
        while (sPos < sLimit) {

            currentCh = s.charAt(sPos);
            patternCh = p.charAt(pPos);

            // case 1 : common pattern and in the middle of pattern
            if (pPos + 1 < pLimit) {
                nextPatternCh = p.charAt(pPos + 1);
                // case 1 : common case no consider about repeat
                if (nextPatternCh != '*') {
                    if (!asSame(currentCh, patternCh)) {
                        return false;
                    } else {
                        pPos++;
                        sPos++;
                    }
                } else {
                    // todo
                    // case 2: where we need consider about repeat
                    // two case to consider
                    // one is after repeat there is no other pattern to match
                    // another is there is other pattern to match
                    if (pPos + 2 < pLimit) {
                        // case 2.1: if there is other pattern to match
                        prevPatternCh = currentCh;
                        currentCh = nextPatternCh;
                        nextPatternCh = p.charAt(pPos + 2);
                        if (nextPatternCh == '+') {
                            return false;
                        }
                        while (!asSame(currentCh, nextPatternCh) && sPos < sLimit) {
                            currentCh = s.charAt(sPos);
                            sPos++;
                        }

                    }
                }
            } else {
                // case 3: close to and end of pattern, so the pPos won't increase
                if (patternCh == '*' && sPos < sLimit - 1) {
                    return false;
                } else {
                    if (!asSame(currentCh, patternCh)) {
                        return false;
                    } else {
                        sPos++;
                    }
                }
            }

        }
        return result;

    }

    private boolean asSame(char s, char p) {
        if (p == '.') {
            return true;
        } else {
            return s == p;
        }
    }
}
