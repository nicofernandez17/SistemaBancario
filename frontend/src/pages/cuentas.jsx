import { useEffect, useState } from "react";
import axios from "axios";

function Cuentas() {
    const [cuentas, setCuentas] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/cuentas")
            .then(res => setCuentas(res.data))
            .catch(err => console.error("Error al obtener cuentas:", err));
    }, []);

    return (
        <div>
            <h1>Cuentas</h1>
            <ul>
                {cuentas.map(c => (
                    <li key={c.numero}>#{c.numero} - Saldo: ${c.saldo}</li>
                ))}
            </ul>
        </div>
    );
}

export default Cuentas;