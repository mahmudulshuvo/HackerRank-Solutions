import Foundation

// Complete the happyLadybugs function below.
func happyLadybugs(b: String) -> String {
    var dic: [Character: Int] = [:]
    
    for i in 0..<b.count {
        let index = b.index(b.startIndex, offsetBy: i)
        dic[b[index]] = (dic[b[index]] ?? 0) + 1
    }

    
    for (key, counts) in dic {
        if(key != "_" && counts <= 1) {
            return "NO"
        }
    }
    
    if (dic["_"] != nil) {
        if (dic["_"]! >= 1) {
            return "YES"
        }
    }
        
    else {
        var temp = b[b.index(b.startIndex, offsetBy: 0)]
        for i in 1..<b.count {
            let index = b[b.index(b.startIndex, offsetBy: i)]
            if (temp == index) {
                temp = index
                continue
            }
            else {
                let next = b[b.index(b.startIndex, offsetBy: i+1)]
                if (next == index) {
                    temp = index
                    continue
                }
                else {
                    return "NO"
                }
            }
        }
    }
    return "YES"

}

let stdout = ProcessInfo.processInfo.environment["OUTPUT_PATH"]!
FileManager.default.createFile(atPath: stdout, contents: nil, attributes: nil)
let fileHandle = FileHandle(forWritingAtPath: stdout)!

guard let g = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
else { fatalError("Bad input") }

for gItr in 1...g {
    guard let n = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
    else { fatalError("Bad input") }

    guard let b = readLine() else { fatalError("Bad input") }

    let result = happyLadybugs(b: b)

    fileHandle.write(result.data(using: .utf8)!)
    fileHandle.write("\n".data(using: .utf8)!)
}