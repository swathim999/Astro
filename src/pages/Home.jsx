/* eslint-disable no-unused-vars */
import { useState } from "react";
import { jsPDF } from "jspdf";
import "./Home.css"

const Home = () => {
  const [formData, setFormData] = useState({
    name: "",
    dob: "",
    birthplace: "",
    sign: "Aries",
  });
  const [message, setMessage] = useState({ text: "", type: "" });

  const zodiacSigns = [
    "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
    "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"
  ];

  const handleChange = (e) => {
    const { id, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [id]: value
    }));
  };

  const generatePDF = () => {
    const { name, dob, birthplace, sign } = formData;

    if (name && dob && birthplace) {
      try {
        const doc = new jsPDF();
        doc.setFont("helvetica", "bold");
        doc.setFontSize(24);
        doc.setTextColor("#f5a623");
        doc.text("Horoscope Report", 105, 20, { align: "center" });

        doc.setFont("helvetica", "normal");
        doc.setFontSize(16);
        doc.setTextColor("#000000");
        
        const content = [
          `Name: ${name}`,
          `Date of Birth: ${new Date(dob).toLocaleDateString()}`,
          `Birth Place: ${birthplace}`,
          `Zodiac Sign: ${sign}`
        ];

        content.forEach((text, index) => {
          doc.text(text, 20, 40 + (index * 10));
        });

        doc.save("Horoscope-Report.pdf");
        setMessage({ text: "Report generated successfully!", type: "success" });
        setTimeout(() => setMessage({ text: "", type: "" }), 3000);
      } catch (error) {
        setMessage({ text: "Error generating report. Please try again.", type: "error" });
      }
    } else {
      setMessage({ text: "Please fill in all the fields before generating the report.", type: "error" });
    }
  };

  return (
    <div className="home-container">
      <div className="home-content">
        <div className={`details-card ${message.text && message.type === "error" ? "error-active" : ""}`}>
          <h2>Personal Details</h2>
          <div className="form-group">
            <label htmlFor="name">Name</label>
            <input
              type="text"
              id="name"
              value={formData.name}
              onChange={handleChange}
              placeholder="Enter your name"
            />
          </div>

          <div className="form-group">
            <label htmlFor="dob">Date of Birth</label>
            <input
              type="date"
              id="dob"
              value={formData.dob}
              onChange={handleChange}
            />
          </div>

          <div className="form-group">
            <label htmlFor="birthplace">Birth Place</label>
            <input
              type="text"
              id="birthplace"
              value={formData.birthplace}
              onChange={handleChange}
              placeholder="Enter your birthplace"
            />
          </div>

          {/* <div className="form-group">
            <label htmlFor="sign">Zodiac Sign</label>
            <select
              id="sign"
              value={formData.sign}
              onChange={handleChange}
            >
              {zodiacSigns.map(sign => (
                <option key={sign} value={sign}>{sign}</option>
              ))}
            </select>
          </div> */}

          <button onClick={generatePDF} className="generate-btn">
            Generate Report
          </button>

          {message.text && (
            <div className={`message ${message.type}`}>
              {message.text}
            </div>
          )}
        </div>

        <div className="chat-card">
          <h1>Chat</h1>
          <div className="coming-soon">
            <h3>Coming Soon</h3>
            <p>Our chat feature is under development</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;