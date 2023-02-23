import { useState, useEffect } from 'react'

function Code() {
    const [data, setData] = useState([])

    useEffect(() => async() => {
        const apiurl = process.env.REACT_APP_API_URL === null ? "http://localhost:5189" : process.env.REACT_APP_API_URL;
        console.log(apiurl);
        const response = await fetch(apiurl, {method:'GET'});
        const body = await response.json();
        await setData(body);
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
            <p>Updated Change</p>
        </div>
 
    );
}


export default Code;