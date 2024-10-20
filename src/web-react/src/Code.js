import { useState, useEffect } from 'react'

function Code() {
    const [data, setData] = useState([])

    const apiurl = process.env.REACT_APP_API_URL === null ? "http://localhost:5189/code" : process.env.REACT_APP_API_URL;

    console.log(apiurl)
    const headers = {
        "Access-Control-Allow-Origin": "*",
        "Content-Type": "application/json",
    }
    useEffect(() => {
        fetch(apiurl, { headers: headers })
          .then((response) => response.json())
          .then((actualData) => setData(actualData));
    }, []);

    
    function convertEmoji(e)
    {
        // Until we can figure out how to serialize emojis, this will have to do.
        if (e === "pineapple") { return "🍍" }
        if (e === "robot") { return "🤖" }
        if (e === "fire") { return "🔥" }
        if (e === "party") { return "🎉" }
        if (e === "ghost") { return "👻" }
        if (e === "skull") { return "💀" }
        if (e === "rocket") { return "🚀" }
        if (e === "puzzle") { return "🧩" }
        return "❓";
    }

    return (
        <div>
            <h1>{convertEmoji(data.Emoji)}</h1>
            <p>{data.Adjective}-{data.Person}</p>
            <p style={{ fontSize: 14 }}>{data.MachineName}</p>
        </div>
 
    );
}


export default Code;