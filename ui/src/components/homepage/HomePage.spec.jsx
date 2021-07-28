import { HomePage } from "./HomePage"
import * as axios from 'axios'
import Enzyme, { mount } from 'enzyme'
import Adapter from 'enzyme-adapter-react-16'
import { act } from "react-dom/test-utils";

jest.mock("axios");
Enzyme.configure({ adapter: new Adapter() })
describe("HomePage spec", () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it("Makes request for savings", async () => {
    let wrapper;

    await act(async () => {
      axios.post.mockImplementationOnce(() => Promise.resolve());
      wrapper = mount(<HomePage />);
      wrapper.find('form').first().simulate('submit');
    });

    wrapper.update();
    await expect(wrapper.find('Results').length).toEqual(1);
  })
});