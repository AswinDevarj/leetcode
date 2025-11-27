class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!m.containsKey(name)) {
                m.put(name, 1);
                continue;
            }
            int n = m.get(name);
            String candidate = name + "(" + n + ")";
            while (m.containsKey(candidate)) {
                n++;
                candidate = name + "(" + n + ")";
            }
            names[i] = candidate;
            m.put(name, n + 1);
            m.put(candidate, 1);
        }
        return names;
    }
}