/* eslint-disable react/no-unescaped-entities */
import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import "./Login.css"

const LoginPage = () => {
    const [formData, setFormData] = useState({
        email: "",
        password: ""
    });
    const [message, setMessage] = useState({ text: "", type: "" });
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { id, value } = e.target;
        setFormData(prev => ({
            ...prev,
            [id]: value
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        
        const users = JSON.parse(localStorage.getItem("users")) || [];
        const user = users.find(
            (user) => user.username === formData.username && 
                     user.password === formData.password
        );

        if (user) {
            setMessage({ text: "Login Successful!", type: "success" });
            setTimeout(() => {
                navigate("/home");
            }, 1000);
        } else {
            setMessage({ text: "Wrong username or password!", type: "error" });
        }
    };

    const handleReset = () => {
        setFormData({
            email: "",
            password: ""
        });
        setMessage({ text: "", type: "" });
    };

    return (
        <div className="login-container">
            <form onSubmit={handleSubmit} className="login-form">
                <fieldset>
                    <legend>LOGIN</legend>
                    <div className="form-group">
                        <label htmlFor="email">Email</label>
                        <input
                            type="email"
                            id="email"
                            placeholder="Enter Email"
                            value={formData.email}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input
                            type="password"
                            id="password"
                            placeholder="Enter password"
                            value={formData.password}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <div className="button-group">
                        <button type="submit" className="submit-btn">
                            Login
                        </button>
                        <button 
                            type="button" 
                            onClick={handleReset}
                            className="reset-btn"
                        >
                            Cancel
                        </button>
                    </div>

                    <p className="signup-link">
                        Don't have an account? <Link to="/signup">Sign Up</Link>
                    </p>

                    {message.text && (
                        <div className={`message ${message.type}`}>
                            {message.text}
                        </div>
                    )}
                </fieldset>
            </form>
        </div>
    );
};

export default LoginPage;