/**
 * @param {string[]} words
 * @param {number} k
 * @return {string[]}
 */
var topKFrequent = function(words, k) {
    let count = {};
    for (let s of words) {
        count[s] = (count[s] || 0 ) + 1;
    }
    let sorted = Object.keys(count).sort((a , b)=> {
        let diff = count[b] - count[a];
        if (diff == 0) return a.localeCompare(b);
        return diff;
    })
    return sorted.slice(0, k);
};