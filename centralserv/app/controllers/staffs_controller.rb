class StaffsController < ApplicationController

  def index
  end

  def new
    @staff = Staff.new
  end

end
