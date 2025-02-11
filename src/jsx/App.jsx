import { createRoot } from 'react-dom/client';
import Calc from './Calc.jsx';

const appelm = document.getElementById('app');
const a = parseInt(appelm.dataset['a']);
const b = parseInt(appelm.dataset['b']);

console.log(`new session id = ${appelm.dataset['sessionid']}`);

const root = createRoot(appelm);
root.render(<Calc default_a={a} default_b={b}/>);

