import { useState, useEffect } from 'react'

function Code() {
    const [data, setData] = useState([])

    useEffect(() => async() => {
        setData("hello-world");
        const response = await fetch('http://localhost:5189/code', {method:'GET'});
        const body = await response.text();
        console.log(body);
        await setData(body);
    }, []);

    return (data)
}

export default Code;