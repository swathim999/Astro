import "../App.css";
import Img from "../assets/img"

const Services = () => {
  return (
    <section className="service">
      <h1>Our Services</h1>
      <div className="service-cards">
        <div className="card">
          <img
            src={Img.Marriage}
            alt="Marriage"
            className="service-img"
          />
          <h3>Marriage</h3>
          <p>
            Want a happy married life? Our matchmaking can predict
            compatibility.
          </p>
          <button>Enquire Now</button>
        </div>
        <div className="card">
          <img
            src={Img.Education}
            alt="Education"
            className="service-img"
          />
          <h3>Education</h3>
          <p>
            Higher studies on your mind? Let us guide you for the best outcomes.
          </p>
          <button>Enquire Now</button>
        </div>
        <div className="card">
          <img
            src={Img.Business}
            alt="Business"
            className="service-img"
          />
          <h3>Business</h3>
          <p>Wish to expand your business? Seek guidance to avoid obstacles</p>
          <button>Enquire Now</button>
        </div>
        <div className="card">
          <img
            src={Img.Wealth}
            alt="Wealth"
            className="service-img"
          />
          <h3>Wealth</h3>
          <p>
            Suffering monetary losses? We can analyze and help resolve doshas.
          </p>
          <button>Enquire Now</button>
        </div>
      </div>
    </section>
  );
};

export default Services;
