import { useState, useEffect } from 'react'

function Code() {
    const [data, setData] = useState("hello-world")

    useEffect(() => async() => {
        const apiurl = process.env.REACT_APP_API_URL;
        console.log(apiurl);
        const response = await fetch(apiurl, {method:'GET'});
        const body = await response.text();
        await setData(body);
    }, []);

    return (data)
}

export default Code;