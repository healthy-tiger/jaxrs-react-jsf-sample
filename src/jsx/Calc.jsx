import { useState } from 'react';
import '../css/Calc.css';

export default function Calc({default_a, default_b}) {
    const [ a, setA ] = useState(default_a);
    const [ b, setB ] = useState(default_b);
    const [ answer, setAnswer ] = useState('');

    async function handleSubmit(evt) {
        evt.preventDefault();
        const form_data = new FormData(evt.currentTarget);
        const url_search_params = new URLSearchParams(form_data);
        const response = await fetch('webapi/execute', { method: 'POST', body: url_search_params});
        const json = await response.json();

        console.log(`current session id = ${json.sessionid}`);

        setAnswer(json.answer);
    }

    let answer_element = null;
    if(answer !== '') {
        answer_element = <span>{answer}</span>;
    }

    return <>
        <form class="question" onSubmit={handleSubmit}>
            <div>
                <input type="number" id="a" name="a" value={a} onChange={evt => setA(evt.target.value)}/>+<input type="number" id="b" name="b" value={b} onChange={evt => setB(evt.target.value)}/>={answer_element}
            </div>
            <div class="control-bar">
                <input type="submit" value="GO"/>
            </div>
        </form>
    </>
}
