import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import "./Signup.css";

const SignUpPage = () => {
    const [formData, setFormData] = useState({
        name: "", email: "", phone: "", 
        gender: "", username: "", password: ""
    });
    const [message, setMessage] = useState({ text: "", type: "" });
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { id, value } = e.target;
        setFormData(prev => ({ ...prev, [id]: value }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        const users = JSON.parse(localStorage.getItem("users")) || [];

        if (users.some(user => user.username === formData.username)) {
            setMessage({ text: "Username already exists!", type: "error" });
            return;
        }

        users.push(formData);
        localStorage.setItem("users", JSON.stringify(users));
        localStorage.setItem("username", formData.username);
        localStorage.setItem("password", formData.password);

        setMessage({ text: "Signup successful!", type: "success" });
        setTimeout(() => navigate("/login"), 2000);
    };

    const handleReset = () => {
        setFormData({
            name: "",
            email: "",
            phone: "",
            gender: "",
            username: "",
            password: "",
        });
        setMessage({ text: "", type: "" });
    };

    return (
        <div className="signup-container">
            <form onSubmit={handleSubmit} className="signup-form">
                <fieldset>
                    <legend>Sign Up</legend>
                    {inputFields.map(field => (
                        <div key={field.id} className="form-group">
                            {field.type === "select" ? (
                                <select
                                    id={field.id}
                                    value={formData[field.id]}
                                    onChange={handleChange}
                                    required
                                >
                                    <option value="" disabled>{field.label}</option>
                                    {field.options.map(opt => (
                                        <option key={opt.value} value={opt.value}>
                                            {opt.label}
                                        </option>
                                    ))}
                                </select>
                            ) : (
                                <input
                                    type={field.type}
                                    id={field.id}
                                    placeholder={field.placeholder}
                                    value={formData[field.id]}
                                    onChange={handleChange}
                                    required
                                />
                            )}
                        </div>
                    ))}

                    <div className="button-group">
                        <button type="submit" className="submit-btn">
                            Create Account
                        </button>
                        <button 
                            type="button" 
                            onClick={handleReset}
                            className="reset-btn"
                        >
                            Cancel
                        </button>
                    </div>

                    <p className="login-link">
                        Have an account? <Link to="/login">Login</Link>
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

const inputFields = [
    { id: "name", type: "text", label: "Name", placeholder: "Enter your name" },
    { id: "email", type: "email", label: "Email", placeholder: "Enter your email" },
    { id: "phone", type: "tel", label: "Phone", placeholder: "Phone number" },
    { 
        id: "gender", 
        type: "select", 
        label: "Gender",
        options: [
            { value: "male", label: "Male" },
            { value: "female", label: "Female" },
            { value: "other", label: "Other" }
        ]
    },
    { id: "username", type: "text", label: "Username", placeholder: "Username" },
    { id: "password", type: "password", label: "Password", placeholder: "Password" },
];

export default SignUpPage;